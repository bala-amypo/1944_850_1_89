@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {

        String email = request.getEmail();
        String role = request.getRole();

        return userService.findByEmail(email)
                .map(user -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
