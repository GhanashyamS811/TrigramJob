package trigram;

import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class TriGramMapper extends Mapper<LongWritable, Text, TriGram, LongWritable>{
	private LongWritable one = new LongWritable(1l);
	
	
	protected void map(LongWritable key, Text value, org.apache.hadoop.mapreduce.Mapper<LongWritable,Text,TriGram,LongWritable>.Context context) throws java.io.IOException ,InterruptedException {
		String temp = value.toString();
		StringTokenizer st = new StringTokenizer(temp, " ");
		String firstWord = st.nextToken();
		String secondWord = "";
		String thirdWord = "";
	
		while(st.hasMoreTokens())
		{
			secondWord = st.nextToken();
			while (st.hasMoreTokens()){
					thirdWord = st.nextToken();
					TriGram trigram = new TriGram();
					trigram.setWord1(firstWord);
					trigram.setWord2(secondWord);
					trigram.setWord3(thirdWord);
					context.write(trigram, one);
					firstWord = secondWord;
					secondWord = thirdWord;
				}
		}
	};

}
