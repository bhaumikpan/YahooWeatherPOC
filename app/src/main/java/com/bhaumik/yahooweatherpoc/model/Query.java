package com.bhaumik.yahooweatherpoc.model;

import com.bhaumik.yahooweatherpoc.model.query.Result;

/**
 * Created by bhaumik on 9/27/17.
 */

public class Query {

    private Integer count;
    private String created; //"2017-09-28T02:46:22Z"
    private String lang;

    private Result results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Query{" +
                "count=" + count +
                ", created='" + created + '\'' +
                ", lang='" + lang + '\'' +
                ", results=" + results +
                '}';
    }
}
