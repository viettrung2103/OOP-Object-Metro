package Week1.Task4.A45.distributions;

/** A continuous generator provides a long value according to the distribution it relies on.
 */
public interface DiscreteGenerator extends Seedable {
    long sample(); 
}
