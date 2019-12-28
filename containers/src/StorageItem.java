public class StorageItem implements Comparable<StorageItem> {
    public int value;
    public StorageItem(int value) {
        this.value = value;
    }
    @Override
    public int compareTo(StorageItem o) {
        if (this.value == o.value) {
            return 0;
        }
        return this.value > o.value ? 1 : -1;
    }
    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
