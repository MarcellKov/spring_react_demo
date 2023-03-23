package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
@Service
public class termekcontroller {
    
    @Autowired
    public Repo repo;

    @Autowired
    public MongoTemplate template;
    

    @GetMapping("/termekek")
    public Object[] termek(){
        return repo.findAll().toArray();
    }

    @PostMapping("/bovit")
    public String bovit(@RequestBody Termek termek ){
     repo.insert(termek);
     return termek.name;
    }

    @GetMapping("/termekek/{id}")
    public void frissit(@PathVariable String id ){
        Criteria c=Criteria.where("id").is(id);
        Query q=Query.query(c);
        Termek termek=template.findOne(q,Termek.class);
        termek.left-=1;
        template.save(termek);
    }

}
