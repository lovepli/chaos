package com.amos.design.creation.factory.method;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/19
 */
public class MultiplyFactory implements IFactory {

    @Override
    public BaseOperation getInstance() {
        return new MultiplyOperation();
    }
}
