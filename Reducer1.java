import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
public class Reducer1 extends Reducer<Text,IntWritable,Text,IntWritable>
{
IntWritable out= new IntWritable();
public void reduce (Text key,Iterable<IntWritable>values,Context context)
throws IOException,InterruptedException
{
	int n=0;
        for(IntWritable value:values)
	{
		n=n+value.get();
	}
	out.set(n);
	context.write(key, out);
}
}