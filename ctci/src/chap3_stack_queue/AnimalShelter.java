package chap3_stack_queue;

/**
 * Animal shelter. Run by this policy: FIFO, people can adopt dogs or cats.
 * @author hkhoi
 */
public interface AnimalShelter {
    
    /**
     * 
     * @param animal 
     */
    public void enque(Animal animal);

    /**
     * Dequeue any animal
     * @return 
     */
    public Animal dequeueAny();

    /**
     * Adopt one cat
     * @return 
     */
    public Animal dequeueCat();
    
    /**
     * Adopt one dog
     * @return 
     */
    public Animal dequeueDog();
}
