package com.oblom.DiplomServer;

import com.oblom.DiplomServer.entities.*;
import com.oblom.DiplomServer.jwt.JwtProvider;
import com.oblom.DiplomServer.jwt.JwtRequest;
import com.oblom.DiplomServer.jwt.JwtResponse;
import com.oblom.DiplomServer.services.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class SelfEmployeedController {
    private final CategoriesService categoriesService;
    private final CustomerService customerService;
    private final FavoritesService favoritesService;
    private final PaymentDescriptionService paymentDescriptionService;
    private final PaymentService paymentService;
    private final PortfolioPicturesService portfolioPicturesService;
    private final RoleService roleService;
    private final SelfEmployeedService selfEmployeedService;
    private final SelfEmployeedSocialNetworksService selfEmployeedSocialNetworksService;
    private final ServicesListService servicesListService;
    private final SocialNetworksService socialNetworksService;
    private final TagsService tagsService;
    @Value("${upload.avatar.selfemployeed.path}")
    private String uploadAvatarSelfEmployeedPath;
    @Value("${upload.avatar.customer.path}")
    private String uploadAvatarCustomerPath;
    @Value("${upload.portfolio.path}")
    private String uploadPortfolioPath;
    @Autowired
    public SelfEmployeedController(CategoriesService categoriesService, CustomerService customerService, FavoritesService favoritesService, PaymentDescriptionService paymentDescriptionService, PaymentService paymentService, PortfolioPicturesService portfolioPicturesService, RoleService roleService, SelfEmployeedService selfEmployeedService, SelfEmployeedSocialNetworksService selfEmployeedSocialNetworksService, ServicesListService servicesListService, SocialNetworksService socialNetworksService, TagsService tagsService) {
        this.categoriesService = categoriesService;
        this.customerService = customerService;
        this.favoritesService = favoritesService;
        this.paymentDescriptionService = paymentDescriptionService;
        this.paymentService = paymentService;
        this.portfolioPicturesService = portfolioPicturesService;
        this.roleService = roleService;
        this.selfEmployeedService = selfEmployeedService;
        this.selfEmployeedSocialNetworksService = selfEmployeedSocialNetworksService;
        this.servicesListService = servicesListService;
        this.socialNetworksService = socialNetworksService;
        this.tagsService = tagsService;
    }
    @Autowired
    private JwtProvider jwtProvider;
    @PostMapping("/customers/register")
    public String registerCustomer(@RequestBody JwtRequest registrationRequest) {
        Customer customer = new Customer();
        customer.setPassword(registrationRequest.getPassword());
        customer.setEmail(registrationRequest.getUsername());
        customer.setRole(roleService.read(2));
        customerService.create(customer);
        return "OK";
    }

    @PostMapping("/customers/auth")
    public JwtResponse authCustomer(@RequestBody JwtRequest request) {
        Customer customer = customerService.findByEmailAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(customer.getEmail());
        return new JwtResponse(token);
    }
    @PostMapping("/selfemployeeds/register")
    public String registerSelfEmployeed(@RequestBody JwtRequest registrationRequest) {
        Self_employeed self_employeed = new Self_employeed();
        self_employeed.setPassword(registrationRequest.getPassword());
        self_employeed.setEmail(registrationRequest.getUsername());
        self_employeed.setRole(roleService.read(3));
        selfEmployeedService.create(self_employeed);
        return "OK";
    }

    @PostMapping("/selfemployeeds/auth")
    public JwtResponse authSelfEmployeed(@RequestBody JwtRequest request) {
        Self_employeed self_employeed = selfEmployeedService.findByEmailAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(self_employeed.getEmail());
        return new JwtResponse(token);
    }



    @PostMapping("/selfemployeeds/avatar/{id}")
    public String uploadAvatarSelfEmployeed(@PathVariable(name = "id") int id,@RequestParam("file") MultipartFile file) throws IOException {
        Self_employeed self_employeed = selfEmployeedService.read(id);
        self_employeed.setPhoto(uploadAvatarSelfEmployeedPath + "/" + id + ".jpeg");
        selfEmployeedService.update(id, self_employeed);
        file.transferTo(new File(uploadAvatarSelfEmployeedPath + id + ".jpeg"));
        return "OK";
    }
    @PostMapping("/customers/avatar/{id}")
    public String uploadAvatarCustomer(@PathVariable(name = "id") int id,@RequestParam("file") MultipartFile file) throws IOException {
        Customer customer = customerService.read(id);
        customer.setPhoto(uploadAvatarCustomerPath + "/" + id + ".jpeg");
        customerService.update(id, customer);
        file.transferTo(new File(uploadAvatarCustomerPath + id + ".jpeg"));
        return "OK";
    }
    @GetMapping(value = "/selfemployeeds/avatar/{id}")
    public ResponseEntity<byte[]> getSelfEmployeedAvatar(@PathVariable(name = "id") int id) throws IOException {

        var imgFile = new ClassPathResource(uploadAvatarSelfEmployeedPath + id + ".jpeg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @GetMapping(value = "/customers/avatar/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getCustomerAvatar(@PathVariable(name = "id") int id) throws IOException {

        var imgFile = new ClassPathResource(uploadAvatarCustomerPath + id + ".jpeg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @GetMapping(value = "/selfemployeeds")
    public ResponseEntity<List<Self_employeed>> readAllSelfEmployeed() {
        final List<Self_employeed> selfEmployeeds = selfEmployeedService.readAll();
        return selfEmployeeds != null && !selfEmployeeds.isEmpty()
                ? new ResponseEntity<>(selfEmployeeds, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/selfemployeeds")
    public ResponseEntity<?> createSelfEmployeed(@RequestBody Self_employeed self_employeed){
        selfEmployeedService.create(self_employeed);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/selfemployeeds/{id}")
    public ResponseEntity<Self_employeed> readOneSelfEmployeed(@PathVariable(name = "id") int id){
        final Self_employeed selfEmployeed = selfEmployeedService.read(id);
        return selfEmployeed != null
                ? new ResponseEntity<>(selfEmployeed, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/selfemployeeds/{id}")
    public ResponseEntity<?> updateSelfEmployeed(@PathVariable(name = "id") int id, @RequestBody Self_employeed self_employeed) {
        final boolean updated = selfEmployeedService.update(id, self_employeed);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/selfemployeeds/{id}")
    public ResponseEntity<?> deleteSelfEmployeed(@PathVariable(name = "id") int id) {
        final boolean deleted = selfEmployeedService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/selfemployeeds/categories/{id}")
    public ResponseEntity<List<Self_employeed>> readAllSelfEmployeedByCategory(@PathVariable(name = "id") int id) {
        final List<Self_employeed> selfEmployeeds = selfEmployeedService.readAllByCategoryId(id);
        return selfEmployeeds != null && !selfEmployeeds.isEmpty()
                ? new ResponseEntity<>(selfEmployeeds, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @GetMapping(value = "/categories")
    public ResponseEntity<List<Categories>> readAllCategories() {
        final List<Categories> categories = categoriesService.readAll();
        return categories != null && !categories.isEmpty()
                ? new ResponseEntity<>(categories, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/categories")
    public ResponseEntity<?> createCategory(@RequestBody Categories categories){
        categoriesService.create(categories);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<Categories> readOneCategory(@PathVariable(name = "id") int id){
        final Categories categories = categoriesService.read(id);
        return categories != null
                ? new ResponseEntity<>(categories, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/categories/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable(name = "id") int id, @RequestBody Categories categories) {
        final boolean updated = categoriesService.update(id, categories);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") int id) {
        final boolean deleted = categoriesService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        final List<Customer> customers = customerService.readAll();
        return customers != null && !customers.isEmpty()
                ? new ResponseEntity<>(customers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        customerService.create(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable(name = "id") int id){
        final Customer customer = customerService.read(id);
        return customer != null
                ? new ResponseEntity<>(customer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable(name = "id") int id, @RequestBody Customer customer) {
        final boolean updated = customerService.update(id, customer);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") int id) {
        final boolean deleted = customerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



    @GetMapping(value = "/favorites")
    public ResponseEntity<List<Favorites>> getAllFavorites() {
        final List<Favorites> favorites = favoritesService.readAll();
        return favorites != null && !favorites.isEmpty()
                ? new ResponseEntity<>(favorites, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/favorites")
    public ResponseEntity<?> createFavorite(@RequestBody Favorites favorites){
        favoritesService.create(favorites);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/favorites/{id}")
    public ResponseEntity<Favorites> getOneFavorite(@PathVariable(name = "id") int id){
        final Favorites favorites = favoritesService.read(id);
        return favorites != null
                ? new ResponseEntity<>(favorites, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/favorites/{id}")
    public ResponseEntity<?> updateFavorite(@PathVariable(name = "id") int id, @RequestBody Favorites favorites) {
        final boolean updated = favoritesService.update(id, favorites);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/favorites/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable(name = "id") int id) {
        final boolean deleted = favoritesService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/favorites/customer/{id}")
    public ResponseEntity<List<Favorites>> getAllFavoritesForCustomer(@PathVariable(name = "id") int id) {
        final List<Favorites> favorites = favoritesService.readAllForCustomer(id);
        return favorites != null && !favorites.isEmpty()
                ? new ResponseEntity<>(favorites, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/favorites/selfemployeed/{id}")
    public ResponseEntity<List<Favorites>> getAllFavoritesForSelfEmployeed(@PathVariable(name = "id") int id) {
        final List<Favorites> favorites = favoritesService.readAllForSelfEmployeed(id);
        return favorites != null && !favorites.isEmpty()
                ? new ResponseEntity<>(favorites, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value = "/payment/{id}/description")
    public ResponseEntity<List<Payment_description>> getAllPaymentDescriptionByPayment(@PathVariable(name = "id") int id) {
        final List<Payment_description> payment_descriptions = paymentDescriptionService.readAllByPaymentId(id);
        return payment_descriptions != null && !payment_descriptions.isEmpty()
                ? new ResponseEntity<>(payment_descriptions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/payment/description")
    public ResponseEntity<?> createPaymentDescription(@RequestBody Payment_description payment_description){
        paymentDescriptionService.create(payment_description);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/payment/description/{id}")
    public ResponseEntity<?> deletePaymentDescription(@PathVariable(name = "id") int id) {
        final boolean deleted = paymentDescriptionService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }




    @GetMapping(value = "/payment")
    public ResponseEntity<List<Payment>> getAllPayments() {
        final List<Payment> payments = paymentService.readAll();
        return payments != null && !payments.isEmpty()
                ? new ResponseEntity<>(payments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/payment")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment){
        paymentService.create(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/payment/{id}")
    public ResponseEntity<Payment> getOnePayment(@PathVariable(name = "id") int id){
        final Payment payment = paymentService.read(id);
        return payment != null
                ? new ResponseEntity<>(payment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/payment/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable(name = "id") int id, @RequestBody Payment payment) {
        final boolean updated = paymentService.update(id, payment);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/payment/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable(name = "id") int id) {
        final boolean deleted = paymentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/customer/payment/{id}")
    public ResponseEntity<List<Payment>> getAllPaymentsForCustomer(@PathVariable(name = "id") int id) {
        final List<Payment> payments = paymentService.readAllByCustomerId(id);
        return payments != null && !payments.isEmpty()
                ? new ResponseEntity<>(payments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/selfemployeed/payment/{id}")
    public ResponseEntity<List<Payment>> getAllPaymentsForSelfEmployeed(@PathVariable(name = "id") int id) {
        final List<Payment> payments = paymentService.readAllBySelfEmployeedId(id);
        return payments != null && !payments.isEmpty()
                ? new ResponseEntity<>(payments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value = "/portfolio")
    public ResponseEntity<List<Portfolio_pictures>> getAllPortfolioPictures() {
        final List<Portfolio_pictures> portfolio_pictures = portfolioPicturesService.readAll();
        return portfolio_pictures != null && !portfolio_pictures.isEmpty()
                ? new ResponseEntity<>(portfolio_pictures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/portfolio")
    public ResponseEntity<?> createPortfolioPicture(@RequestBody Portfolio_pictures portfolio_pictures){
        portfolioPicturesService.create(portfolio_pictures);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/portfolio/{id}")
    public ResponseEntity<Portfolio_pictures> getOnePortfolioPicture(@PathVariable(name = "id") int id){
        final Portfolio_pictures portfolio_pictures = portfolioPicturesService.read(id);
        return portfolio_pictures != null
                ? new ResponseEntity<>(portfolio_pictures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/portfolio/{id}")
    public ResponseEntity<?> deletePortfolioPicture(@PathVariable(name = "id") int id) {
        final boolean deleted = portfolioPicturesService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/selfemployeed/portfolio/{id}")
    public ResponseEntity<List<Portfolio_pictures>> getAllPortfolioPicturesBySelfEmployeedid(@PathVariable(name = "id") int id) {
        final List<Portfolio_pictures> portfolio_pictures = portfolioPicturesService.readAllBySelfEmployeedId(id);
        return portfolio_pictures != null && !portfolio_pictures.isEmpty()
                ? new ResponseEntity<>(portfolio_pictures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value = "/selfemployeeds/socialnetworks")
    public ResponseEntity<List<Self_employeed_social_networks>> getAllSelfEmployeedSocialNetworks() {
        final List<Self_employeed_social_networks> selfEmployeedSocialNetworks = selfEmployeedSocialNetworksService.readAll();
        return selfEmployeedSocialNetworks != null && !selfEmployeedSocialNetworks.isEmpty()
                ? new ResponseEntity<>(selfEmployeedSocialNetworks, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/selfemployeeds/socialnetworks")
    public ResponseEntity<?> createSelfEmployeedSocialNetwork(@RequestBody Self_employeed_social_networks self_employeed_social_networks){
        selfEmployeedSocialNetworksService.create(self_employeed_social_networks);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(value = "/selfemployeeds/socialnetworks/{id}")
    public ResponseEntity<?> updateSelfEmployeedSocialNetwork(@PathVariable(name = "id") int id, @RequestBody Self_employeed_social_networks self_employeed_social_networks) {
        final boolean updated = selfEmployeedSocialNetworksService.update(id, self_employeed_social_networks);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/selfemployeeds/socialnetworks/{id}")
    public ResponseEntity<?> deleteSelfEmployeedSocialNetwork(@PathVariable(name = "id") int id) {
        final boolean deleted = selfEmployeedSocialNetworksService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/selfemployeed/{id}/socialnetworks")
    public ResponseEntity<List<Portfolio_pictures>> getAllSelfEmployeedSocialNetworksBySelfEmployeedid(@PathVariable(name = "id") int id) {
        final List<Portfolio_pictures> portfolio_pictures = portfolioPicturesService.readAllBySelfEmployeedId(id);
        return portfolio_pictures != null && !portfolio_pictures.isEmpty()
                ? new ResponseEntity<>(portfolio_pictures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value = "/services")
    public ResponseEntity<List<Services_list>> getAllServices() {
        final List<Services_list> services = servicesListService.readAll();
        return services != null && !services.isEmpty()
                ? new ResponseEntity<>(services, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/services")
    public ResponseEntity<?> createService(@RequestBody Services_list service){
        servicesListService.create(service);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/services/{id}")
    public ResponseEntity<Services_list> getOneService(@PathVariable(name = "id") int id){
        final Services_list service = servicesListService.read(id);
        return service != null
                ? new ResponseEntity<>(service, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/service/{id}")
    public ResponseEntity<?> updateService(@PathVariable(name = "id") int id, @RequestBody Services_list service) {
        final boolean updated = servicesListService.update(id, service);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable(name = "id") int id) {
        final boolean deleted = servicesListService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/selfemployeed/{id}/services")
    public ResponseEntity<List<Services_list>> getAllServicesBySelfEmployeedid(@PathVariable(name = "id") int id) {
        final List<Services_list> services_list = servicesListService.readAllBySelfEmployeedId(id);
        return services_list != null && !services_list.isEmpty()
                ? new ResponseEntity<>(services_list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value = "/socialnetworks")
    public ResponseEntity<List<Social_networks>> getAllSocialNetworks() {
        final List<Social_networks> social_networks = socialNetworksService.readAll();
        return social_networks != null && !social_networks.isEmpty()
                ? new ResponseEntity<>(social_networks, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/socialnetworks")
    public ResponseEntity<?> createSocialNetwork(@RequestBody Social_networks social_networks){
        socialNetworksService.create(social_networks);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/socialnetworks/{id}")
    public ResponseEntity<Social_networks> getOneSocialNetwork(@PathVariable(name = "id") int id){
        final Social_networks social_networks = socialNetworksService.read(id);
        return social_networks != null
                ? new ResponseEntity<>(social_networks, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/socialnetworks/{id}")
    public ResponseEntity<?> updateSocialNetwork(@PathVariable(name = "id") int id, @RequestBody Social_networks social_networks) {
        final boolean updated = socialNetworksService.update(id, social_networks);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/socialnetworks/{id}")
    public ResponseEntity<?> deleteSocialNetwork(@PathVariable(name = "id") int id) {
        final boolean deleted = socialNetworksService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



    @GetMapping(value = "/tags")
    public ResponseEntity<List<Tags>> getAllTags() {
        final List<Tags> tags = tagsService.readAll();
        return tags != null && !tags.isEmpty()
                ? new ResponseEntity<>(tags, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/tags")
    public ResponseEntity<?> createTag(@RequestBody Tags tags){
        tagsService.create(tags);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/tags/{id}")
    public ResponseEntity<Tags> getOneTag(@PathVariable(name = "id") int id){
        final Tags tags = tagsService.read(id);
        return tags != null
                ? new ResponseEntity<>(tags, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/tags/{id}")
    public ResponseEntity<?> updateTag(@PathVariable(name = "id") int id, @RequestBody Tags tags) {
        final boolean updated = tagsService.update(id, tags);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/tags/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable(name = "id") int id) {
        final boolean deleted = tagsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/selfemployeed/{id}/tags")
    public ResponseEntity<List<Tags>> getAllTagsBySelfEmployeedid(@PathVariable(name = "id") int id) {
        final List<Tags> tags = tagsService.readAllBySelfEmployeedId(id);
        return tags != null && !tags.isEmpty()
                ? new ResponseEntity<>(tags, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
