package prototype.greatest;

import lombok.Data;

import java.io.Serializable;

/**
 * 金箍棒变长变短
 * @author wangkun
 * @date 2019-07-19 00:19
 */

@Data
public class GoldenCudgel implements Serializable {

    private int length;


    public int lengthened(){
        return length * 2 ;
    }

    public int shortened(){
        return length / 2 ;
    }
}
