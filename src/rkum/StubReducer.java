package rkum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, Text, Text, Text>{
	
	public void reduce(Text key, Iterable<Text> values, Context context)
		throws IOException, InterruptedException {
		
		ArrayList<String> strArrList = new ArrayList<String>();
		for(Text iw:values)
		{
			strArrList.add(iw.toString());
			System.err.println("RKUMLOG:This is a log.");
		}
		
		//Sort the array list to get the worth in the beginning of the list
		Collections.sort(strArrList);
				
		context.write(key, new Text(strArrList.toString()));
	}
}
