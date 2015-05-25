package rkum;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;


public class StubMapper extends Mapper<Object, Text, Text, Text>{

	@Override
	public void map(Object key, Text value, Context context)
	throws IOException, InterruptedException {
	
	String[] words= new String[2];
	int i=0;
	
	//Split the lines into words with spaces or tabs as separators
	StringTokenizer stringTokenizer = new StringTokenizer (value.toString(), " ");
	while (stringTokenizer.hasMoreElements ())
		{
			words[i]= (String)stringTokenizer.nextElement();
		    i++;
		}
	context.write(new Text(words[0]), new Text(words[1]));
	System.err.println("RKUMLOG:This is a mapper.");
	}
}
