package com.example.demo;



import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;



public class proba extends MongoTemplate{

    public proba(MongoDatabaseFactory mongoDbFactory) {
        super(mongoDbFactory);
        //TODO Auto-generated constructor stub
    }

    public Termek updaTermek(String id){
        Query query=new Query().addCriteria(Criteria.where(id).is(id));
        Termek t=findOne(query,Termek.class);
        Update update = new Update().set("left", t.left-1);
        FindAndModifyOptions options=new FindAndModifyOptions().returnNew(true).upsert(true);
        return findAndModify(query, update, options,Termek.class);
   }
}
