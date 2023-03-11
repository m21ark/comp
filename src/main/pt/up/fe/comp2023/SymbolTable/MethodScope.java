package pt.up.fe.comp2023.SymbolTable;

import pt.up.fe.comp.jmm.analysis.table.Symbol;
import pt.up.fe.comp.jmm.analysis.table.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MethodScope {
    String methodName;
    List<Symbol> parameters;
    Type returnType;
    HashMap<String, Symbol> localVariables = new HashMap<>();

    // ========================== CONSTRUCTOR ==========================

    public MethodScope(Type returnT, String name, List<Symbol> MethodParameters) {
        methodName = name;
        returnType = returnT;
        parameters = Objects.requireNonNullElseGet(MethodParameters, List::of);
    }

    // ========================== GETTERS / SETTERS ==========================

    public String getMethodName() {
        return methodName;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Symbol> getParameters() {
        return parameters;
    }

    public void setParameters(List<Symbol> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(Symbol parameter) {
        this.parameters.add(parameter);
    }

    public Symbol getParameter(String name) {
        for (Symbol p : parameters)
            if (p.getName().equals(name)) return p;
        return null;
    }

    public boolean isParameter(String parameterLabel) {
        for (Symbol p : parameters)
            if (p.getName().equals(parameterLabel)) return true;
        return false;
    }


    public List<Symbol> getLocalVariables() {
        return new ArrayList<>(localVariables.values());
    }

    public Symbol getLocalVariable(String variableName) {
        return localVariables.get(variableName);
    }


    public Boolean addLocalVariable(Symbol var) {
        if (localVariables.containsKey(var.getName())) return false; // already exists
        localVariables.put(var.getName(), var);
        return true;
    }

    public boolean assignVariable(Symbol var) {
        if (localVariables.containsKey(var.getName())) return false; // already exists
        localVariables.put(var.getName(), var);
        return true;
    }

    public boolean hasLocalVariable(String variableName) {
        return localVariables.containsKey(variableName);
    }


    // ========================== PRINT ==========================

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Method: " + methodName + " (");
        for (Symbol p : parameters)
            s.append(p).append(", ");
        s.append(") -> ").append(returnType.toString()).append(" {");
        for (Symbol v : this.getLocalVariables())
            s.append(v).append(", ");
        s.append("}");
        return s + "\n\n";
    }

}