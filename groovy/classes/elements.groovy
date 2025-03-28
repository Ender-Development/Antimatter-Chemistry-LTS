
public class elements {
    private Map<String, List<Integer>> elements = new HashMap<String, List<Integer>>()

    public void addElement(String element, List<Integer> color) {
        if (!elements.containsKey(element)) {
            elements.put(element, color)
        } else {
            log.error("Element already exists")
        }
    }


}