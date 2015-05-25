package rkum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;


public class StubMapper1 extends Mapper<Object, Text, Text, LongWritable>{

	public static boolean isParsable(String input){
	    boolean parsable = true;
	    try{
	        Integer.parseInt(input);
	    }
	    catch(NumberFormatException e){
	        parsable = false;
	    }
	    return parsable;
	}	
	
	@Override
	public void map(Object key, Text value, Context context)
	throws IOException, InterruptedException {
	
	ArrayList<String> strArrList = new ArrayList<String>();
	int worth = 0;
	
	String s=value.toString().replaceAll("[\t]",",");
	s=s.toString().replaceAll("[^a-zA-Z0-9,]","");
		
	StringTokenizer stringTokenizer = new StringTokenizer (s.toString(), ",");
	while (stringTokenizer.hasMoreElements ())
	{
		String v=stringTokenizer.nextElement().toString();

		if(isParsable(v))
			worth=Integer.parseInt(v);
		else
			strArrList.add(v);
	}
	
	int listSize=strArrList.size();

	//Emit all names in value with worth
	for(int i=1;i<listSize;i++)
	{	
			context.write(new Text(strArrList.get(i)),new LongWritable(worth));
	}
	
	//Emit Key and worth 0
	context.write(new Text(strArrList.get(0)),new LongWritable(0));
	}
}
