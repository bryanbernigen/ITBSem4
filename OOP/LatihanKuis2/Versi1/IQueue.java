public interface IQueue<T> {
    public void enqueue(T member);
    public T dequeue();
}
