package cn.edu.lcu.cs.designpattern.visitor.score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Visitor {
    private String name;

    public abstract void visit(JavaScore score);

    public abstract void visit(DesignPatternScore score);
}
