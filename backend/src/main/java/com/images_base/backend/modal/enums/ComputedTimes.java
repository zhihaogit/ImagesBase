package com.images_base.backend.modal.enums;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/21
 */
public enum ComputedTimes {
    /**
     * 不参与统计使用次数
     */
    NOT_COMPUTED(1);

    public final int computedValue;

    ComputedTimes(int computedValue) {
        this.computedValue = computedValue;
    }

    @Override
    public String toString() {
        return "ComputedTimes{" +
                "computedValue=" + computedValue +
                '}';
    }

    public int getComputedValue() {
        return computedValue;
    }
}
