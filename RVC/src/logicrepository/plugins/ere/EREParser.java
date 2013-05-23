/* Generated By:JavaCC: Do not edit this line. EREParser.java */
package logicrepository.plugins.ere;

import java.util.ArrayList;
import java.io.*;

public class EREParser implements EREParserConstants {
  public static EREParser parse(String input) {
     Reader reader = new StringReader(input);
     EREParser ereParser = new EREParser(reader);

     try{
      ereParser.Start();
          }
     catch(Exception e){
      System.err.println(e.getMessage());
      System.exit(1);
          }
     return ereParser;
  }

  private ERE ere;

  public ERE getERE(){
    return ere;
  }

  final public void Start() throws ParseException {
    ere = Ere();
    jj_consume_token(0);
  }

  final public ERE Ere() throws ParseException {
  ERE sub1 = null;
  ERE sub2 = null;
  ArrayList<ERE> children;
          children = new ArrayList<ERE>();
    sub1 = And();
                 children.add(sub1);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(OR);
      sub2 = And();
             children.add(sub2);
    }
          if(children.size() == 1) {if (true) return sub1;}
          {if (true) return Or.get(children);}
    throw new Error("Missing return statement in function");
  }

  final public ERE And() throws ParseException {
  ERE sub1;
  ERE neg1;
  ERE sub2;
  ArrayList<ERE> children;
          children = new ArrayList<ERE>();
    sub1 = Cat();
                  neg1 = Negation.get(sub1); children.add(neg1);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      jj_consume_token(AND);
      sub2 = Cat();
             children.add(Negation.get(sub2));
    }
          if(children.size() == 1) {if (true) return sub1;}
          {if (true) return Negation.get(Or.get(children));}
    throw new Error("Missing return statement in function");
  }

  final public ERE Cat() throws ParseException {
  ERE sub1;
  ERE sub2;
  ArrayList<ERE> children;
     children = new ArrayList<ERE>();
    sub1 = Unary();
                        children.add(sub1);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
      case NEG:
      case EPSILON:
      case EMPTY:
      case SYMBOL:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      sub2 = Unary();
            children.add(sub2);
    }
     if(children.size() == 1) {if (true) return sub1;}
          int size = children.size();
          ERE c = Concat.get(children.get(size - 2), children.get(size - 1));
     for(int i = children.size() - 3; i >= 0; --i){
       c = Concat.get(children.get(i), c);
          }
          {if (true) return c;}
    throw new Error("Missing return statement in function");
  }

  final public ERE Unary() throws ParseException {
  ERE sub;
  Token name;
  Symbol s;
  Epsilon ep;
  Empty em;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NEG:
      jj_consume_token(NEG);
      sub = Unary();
                       {if (true) return Negation.get(sub);}
      break;
    case SYMBOL:
      name = jj_consume_token(SYMBOL);
                      s = Symbol.get(name.image);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case PLUS:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
          jj_consume_token(PLUS);
                             {if (true) return Concat.get(s, Kleene.get(s));}
          break;
        case STAR:
          jj_consume_token(STAR);
                             {if (true) return Kleene.get(s);}
          break;
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
                             {if (true) return s;}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      sub = Ere();
      jj_consume_token(RPAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case PLUS:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
          jj_consume_token(PLUS);
                                 {if (true) return Concat.get(sub, Kleene.get(sub));}
          break;
        case STAR:
          jj_consume_token(STAR);
                                 {if (true) return Kleene.get(sub);}
          break;
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
                                                                         {if (true) return sub;}
      break;
    case EPSILON:
      jj_consume_token(EPSILON);
                      ep = Epsilon.get();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case PLUS:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
          jj_consume_token(PLUS);
                             {if (true) return Concat.get(ep, Kleene.get(ep));}
          break;
        case STAR:
          jj_consume_token(STAR);
                             {if (true) return Kleene.get(ep);}
          break;
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[8] = jj_gen;
        ;
      }
                             {if (true) return ep;}
      break;
    case EMPTY:
      jj_consume_token(EMPTY);
                      em = Empty.get();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case PLUS:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
          jj_consume_token(PLUS);
                             {if (true) return Concat.get(em, Kleene.get(em));}
          break;
        case STAR:
          jj_consume_token(STAR);
                             {if (true) return Kleene.get(em);}
          break;
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
                             {if (true) return em;}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public EREParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40,0x20,0xe14,0x180,0x180,0x180,0x180,0x180,0x180,0x180,0x180,0xe14,};
   }

  /** Constructor with InputStream. */
  public EREParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public EREParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new EREParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public EREParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new EREParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public EREParser(EREParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(EREParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[14];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 14; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
