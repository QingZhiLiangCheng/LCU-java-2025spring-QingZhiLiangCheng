package cn.edu.lcu.cs.basic.relationship.composition;

import lombok.Data;

/**
 * @description: 脑袋
 * @author: ling
 * @since: 2021-08-24 15:55
 **/
@Data
public class Head {
    private Nose nose;
    private Mouth mouth;
    private Eye leftEye;
    private Eye rightEye;
}
