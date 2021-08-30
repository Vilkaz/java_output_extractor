package com.serverless.model;

import java.util.Map;

public class TerraformStack {

    private Map<String, Object> outputs;

    public Map<String, Object> getOutputs() {
        return outputs;
    }

    public void setOutputs(Map<String, Object> outputs) {
        this.outputs = outputs;
    }

    @Override
    public String toString() {
        return "TerraformStack{" +
                "outputs=" + outputs +
                '}';
    }
}
