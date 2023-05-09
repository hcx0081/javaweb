package com.javaweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code @Description:}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message<R, D> {
    private String sender;
    private R receiver;
    private D data;
    private String type;
}