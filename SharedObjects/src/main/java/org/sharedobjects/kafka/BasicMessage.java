package org.sharedobjects.kafka;

import java.io.Serializable;

public record BasicMessage(String message) implements Serializable {
}
