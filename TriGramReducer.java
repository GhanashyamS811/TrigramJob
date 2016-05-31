package trigram;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class TriGramReducer extends Reducer<TriGram, LongWritable, TriGram, LongWritable>{

	protected void reduce(TriGram key, java.lang.Iterable<LongWritable> values, 
			org.apache.hadoop.mapreduce.Reducer<TriGram,LongWritable,TriGram,LongWritable>.Context context) 
			throws java.io.IOException ,InterruptedException {
		long sum = 0;
		while (values.iterator().hasNext()) {
			sum += values.iterator().next().get();
		}
		context.write(key, new LongWritable(sum));
	};

}
