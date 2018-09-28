package io.anserini.search.query;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;

public class LuceneQueryGenerator extends QueryGenerator {

	  public Query buildQuery(String field, Analyzer analyzer, String queryText) {

			QueryParser qp = new QueryParser(field, analyzer);
			try {
			
				return qp.parse(queryText);
			
			} catch (ParseException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		  		  
	  }
	
}
