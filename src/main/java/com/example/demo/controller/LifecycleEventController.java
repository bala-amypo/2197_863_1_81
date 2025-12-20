@RestController
@RequestMapping("/api/lifecycle-events")
public class LifecycleEventController {

    private final LifecycleEventService lifecycleEventService;

    public LifecycleEventController(LifecycleEventService lifecycleEventService) {
        this.lifecycleEventService = lifecycleEventService;
    }

    @PostMapping("/{assetId}")
    public LifecycleEvent create(@PathVariable Long assetId,
                                 @RequestBody LifecycleEvent event) {
        return lifecycleEventService.createLifecycleEvent(assetId, event);
    }

    @GetMapping
    public List<LifecycleEvent> getAll() {
        return lifecycleEventService.getAllLifecycleEvents();
    }

    @GetMapping("/{id}")
    public LifecycleEvent getById(@PathVariable Long id) {
        return lifecycleEventService.getLifecycleEventById(id);
    }
}
