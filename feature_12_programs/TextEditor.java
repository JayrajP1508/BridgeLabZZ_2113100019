package Assignment14;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int historySize;
    private int count;

    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.count = 0;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }
        current = newState;
        count++;

        // Maintain history size limit
        while (count > historySize) {
            if (current.prev != null) {
                current.prev.prev = null;
                current.prev = null;
            }
            count--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        System.out.println("Current State: " + (current != null ? current.content : "[Empty]"));
    }
}