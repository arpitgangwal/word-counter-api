package com.word.counter.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationFailedResponse {
    private List<ViolationErrors> violations = new ArrayList<>();
    public List<ViolationErrors> getViolations() {
        return violations;
    }
    public void setViolations(List<ViolationErrors> violations) {
        this.violations = violations;
    }
}
