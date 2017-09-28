package com.bhaumik.yahooweatherpoc.server.util;

import com.bhaumik.yahooweatherpoc.model.Query;

/**
 * Created by bhaumik on 9/27/17.
 */

public class YahooResponse {
    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "YahooResponse{" +
                "query=" + query +
                '}';
    }
}
