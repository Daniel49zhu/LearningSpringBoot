package com.zjc.batch;

import com.zjc.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    public static final String TEST_NATION = "汉族";

    @Override
    public Person process(Person item) throws ValidationException {
        // 需执行super.process(item); 才会调用自定义校验器
        super.process(item);

        // 对数据做简单的处理，若民族为汉族，则数据转换成01，其余转换成02
        if(TEST_NATION.equals(item.getNation())){
            item.setNation("01");
        }else {
            item.setNation("02");
        }
        return item;
    }
}