package com.exumple.nota;


import com.exumple.nota.Repos.RomanRepos;
import com.exumple.nota.domain.Roman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
// Так называемый REST контроллер
@Controller
public class ReController {

    // Привязка к репозиторию
    @Autowired
    private RomanRepos romanRepos;
    // Метод вывода всех данных с таблицы в список, findAll() в итеративную переменную chi, которая через
    // model.put() отправляется заместо "numbers" в front end
    @GetMapping
    private String main(Map<String, Object> model) {
        Iterable<Roman> chi = romanRepos.findAll();

        model.put("numbers", chi);

        return "main";
    }
    // Метод для записи данных в БД, запрагивает параметр number
    // после вставки также использует findAll() 
    @PostMapping
    public String add(@RequestParam Integer number, Map<String, Object> model) {
        Roman chi = new Roman(number);

        romanRepos.save(chi);

        Iterable<Roman> num = romanRepos.findAll();
        model.put("numbers", num);

        return "main";
    }
}
