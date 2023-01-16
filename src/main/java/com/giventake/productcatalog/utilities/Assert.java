package com.giventake.productcatalog.utilities;

import com.giventake.productcatalog.entities.ProductType;
import com.giventake.productcatalog.exceptions.BusinessException;
import com.giventake.productcatalog.exceptions.ExceptionPayload;
import com.giventake.productcatalog.exceptions.ExceptionPayloadFactory;
import org.springframework.http.HttpStatus;

public interface Assert {
    ExceptionPayload requiredField = ExceptionPayloadFactory.REQUIRED_FIELD.get();
    ExceptionPayload unknownValue = ExceptionPayloadFactory.UNKOWN_VALUE.get();
    ExceptionPayload minValue = ExceptionPayloadFactory.MIN_VALUE.get();


    static public void assertNotNull(Object value){

        if(value == null) throw new BusinessException(requiredField);
    }

    static public void assertNotEmpty(String value){

        if(value == null || value.isEmpty()) throw new BusinessException(requiredField);
    }

    static  public  void assertMinValue(long value, long min){

        if( value < min ) throw new BusinessException(minValue);
    }

}
