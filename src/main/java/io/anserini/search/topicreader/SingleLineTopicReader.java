package io.anserini.search.topicreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SingleLineTopicReader extends TopicReader<Integer> {

	public SingleLineTopicReader(Path topicFile) {	
		super(topicFile);
	}
	
	@Override
	public SortedMap<Integer, Map<String, String>> read(BufferedReader bRdr) throws IOException {
		
		SortedMap<Integer, Map<String, String>> map = new TreeMap<>();
		
		String line;
		while ((line = bRdr.readLine()) != null) {
			
			String[] fields = line.split(":");
			Integer topicId = Integer.parseInt(fields[0]);
			String title = fields[1];
			Map<String,String> map0 = new HashMap<>();
			map0.put("title", title);
			map.put(topicId, map0);
		}
		
		return map;
	}

}
