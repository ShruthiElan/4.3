import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 


public class Mapper1 extends Mapper<LongWritable, Text, Text, IntWritable> {
	Text t=new Text();
	IntWritable n=new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] a=value.toString().split("\t");
		t.set(a[1]); 
			context.write(n,t);
}
}