package segment_tree.evaluator;

public abstract class SegmentEvaluatorAdapter implements SegmentEvaluator {
    public final int notFound;

    protected SegmentEvaluatorAdapter(int notFound){
        this.notFound = notFound;
    }
}