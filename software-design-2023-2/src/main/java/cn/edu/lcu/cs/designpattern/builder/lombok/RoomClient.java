package cn.edu.lcu.cs.designpattern.builder.lombok;

import java.util.Date;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-06 16:50
 **/
public class RoomClient {
    public static void main(String[] args) {
        Room room = Room.builder().active(true)
                .name("name")
                .id("id")
                .createTime(new Date())
                .occupation("1")
                .occupation("2")
                .build();
        System.out.println(room);
//        Assert.assertEquals(2, room.getOccupations().size());

    }
}
