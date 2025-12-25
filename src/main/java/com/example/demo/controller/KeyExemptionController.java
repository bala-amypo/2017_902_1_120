@RestController
@RequestMapping("/api/key-exemptions")
public class KeyExemptionController {

    private final KeyExemptionService keyExemptionService;

    public KeyExemptionController(KeyExemptionService keyExemptionService) {
        this.keyExemptionService = keyExemptionService;
    }

    @GetMapping
    public List<KeyExemption> getAllKeyExemptions() {
        return keyExemptionService.getAllExemptions();
    }

    @PostMapping
    public KeyExemption create(@RequestBody KeyExemption exemption) {
        return keyExemptionService.create(exemption);
    }
}
