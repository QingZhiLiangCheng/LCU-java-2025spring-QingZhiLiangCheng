package cn.edu.lcu.cs.architecture.pipe.ore2;

import java.io.Serializable;

import static cn.edu.lcu.cs.architecture.pipe.ore2.Ore.OreGrade.*;

/**
 * 矿石，不同尺寸代表不同品质
 */
public class Ore implements Serializable {
    private Double size;
    private OreGrade grade;

    public Ore(Double size) {
        setSize(size);
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
        if (size >= SPECIAL.sizeThreshold) {
            this.grade = SPECIAL;
        } else if (size >= GRADE_ONE.sizeThreshold) {
            this.grade = GRADE_ONE;
        } else if (size >= GRADE_TWO.sizeThreshold) {
            this.grade = GRADE_TWO;
        } else if (size >= UNGRADED.sizeThreshold) {
            this.grade = UNGRADED;
        } else {
            this.grade = WASTE;
        }
    }

    public OreGrade getGrade() {
        return grade;
    }


    /**
     * 矿石品级，特级，一级，二级，次品，废料
     */
    public enum OreGrade {
        SPECIAL("特级", 4D), GRADE_ONE("一级", 3D), GRADE_TWO("二级", 2D), UNGRADED("次品", 1D), WASTE("废料", 0D);

        private String name;

        /**
         * 矿石尺寸阈值，相应品质需高于特定阈值
         */
        private Double sizeThreshold;

        public Double getSizeThreshold() {
            return sizeThreshold;
        }

        private OreGrade(String name, Double sizeThreshold) {
            this.name = name;
            this.sizeThreshold = sizeThreshold;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
