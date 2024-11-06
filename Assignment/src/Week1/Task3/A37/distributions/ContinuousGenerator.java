package Week1.Task3.A37.distributions;

/** A continuous generator provides a double value according to the distribution it relies on.
 */
public interface ContinuousGenerator extends Seedable {
    double sample(); 
}
