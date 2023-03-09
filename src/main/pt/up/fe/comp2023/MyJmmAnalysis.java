package pt.up.fe.comp2023;

import pt.up.fe.comp.jmm.analysis.JmmAnalysis;
import pt.up.fe.comp.jmm.analysis.JmmSemanticsResult;
import pt.up.fe.comp.jmm.parser.JmmParserResult;
import pt.up.fe.comp2023.SymbolTable.MySymbolTable;

import java.util.ArrayList;

public class MyJmmAnalysis implements JmmAnalysis {
    @Override
    public JmmSemanticsResult semanticAnalysis(JmmParserResult jmmParserResult) {


        MySymbolTable st = new MySymbolTable("Super", "UltraSuper"); // N é necessário o nome da classe e a superclasse, correto ?
        st = st.populateSymbolTable(jmmParserResult);

        /*
        st.addImport("java.lang.System");
        st.addImport("java.lang.Math");

        MySymbol param1 = new MySymbol(new Type("int", false), "param1", 1);
        MySymbol param2 = new MySymbol(new Type("boolean", false), "param2", 2);
        MySymbol param3 = new MySymbol(new Type("Parameters", false), "param3", 3);

        List<MySymbol> paramList = new ArrayList<MySymbol>();
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);

        MethodScope func = new MethodScope(new Type("int", false), "main", paramList);
        st.addMethod("main", func);
    */


        return new JmmSemanticsResult(jmmParserResult, st, new ArrayList<>());
    }
}
