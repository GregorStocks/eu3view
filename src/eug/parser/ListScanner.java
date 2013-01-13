/* The following code was generated by JFlex 1.4.1 on 7/11/07 6:16 PM */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * ListScanner.java                                                          *
 * This file is generated from listScanner.flex. Please edit that file if    *
 * you wish to make changes.                                                 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package eug.parser;

import java.util.List;
import java.util.ArrayList;

/**
 * This scanner parses list items from something like:
 * <code>
 *  "New Zealand"#Important
 *              Ontario
 *              "Quebec" "British Columbia"
 * </code>
 * <p>
 * This is an internal class, meant for use only by {@link EUGScanner}.
 * @author Michael Myers
 * @since EUGFile 1.01.00
 */

final class ListScanner {

  /** This character denotes the end of file */
  private static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  private static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\2\2\1\3\2\0\1\3\22\0\1\2\1\0\1\5\1\4"+
    "\3\0\1\1\5\0\1\1\1\1\1\0\12\1\7\0\33\1\1\0"+
    "\1\1\1\0\1\1\1\0\32\1\55\0\1\1\1\0\1\1\11\0"+
    "\2\1\4\0\1\1\5\0\27\1\1\0\37\1\1\0\u013f\1\31\0"+
    "\162\1\4\0\14\1\16\0\5\1\11\0\1\1\213\0\1\1\13\0"+
    "\1\1\1\0\3\1\1\0\1\1\1\0\24\1\1\0\54\1\1\0"+
    "\46\1\1\0\5\1\4\0\202\1\10\0\105\1\1\0\46\1\2\0"+
    "\2\1\6\0\20\1\41\0\46\1\2\0\1\1\7\0\47\1\110\0"+
    "\33\1\5\0\3\1\56\0\32\1\5\0\13\1\43\0\2\1\1\0"+
    "\143\1\1\0\1\1\17\0\2\1\7\0\2\1\12\0\3\1\2\0"+
    "\1\1\20\0\1\1\1\0\36\1\35\0\3\1\60\0\46\1\13\0"+
    "\1\1\u0152\0\66\1\3\0\1\1\22\0\1\1\7\0\12\1\43\0"+
    "\10\1\2\0\2\1\2\0\26\1\1\0\7\1\1\0\1\1\3\0"+
    "\4\1\3\0\1\1\36\0\2\1\1\0\3\1\16\0\2\1\23\0"+
    "\6\1\4\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0"+
    "\2\1\1\0\2\1\37\0\4\1\1\0\1\1\23\0\3\1\20\0"+
    "\11\1\1\0\3\1\1\0\26\1\1\0\7\1\1\0\2\1\1\0"+
    "\5\1\3\0\1\1\22\0\1\1\17\0\2\1\43\0\10\1\2\0"+
    "\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0\5\1\3\0"+
    "\1\1\36\0\2\1\1\0\3\1\17\0\1\1\21\0\1\1\1\0"+
    "\6\1\3\0\3\1\1\0\4\1\3\0\2\1\1\0\1\1\1\0"+
    "\2\1\3\0\2\1\3\0\3\1\3\0\10\1\1\0\3\1\113\0"+
    "\10\1\1\0\3\1\1\0\27\1\1\0\12\1\1\0\5\1\46\0"+
    "\2\1\43\0\10\1\1\0\3\1\1\0\27\1\1\0\12\1\1\0"+
    "\5\1\3\0\1\1\40\0\1\1\1\0\2\1\43\0\10\1\1\0"+
    "\3\1\1\0\27\1\1\0\20\1\46\0\2\1\43\0\22\1\3\0"+
    "\30\1\1\0\11\1\1\0\1\1\2\0\7\1\72\0\60\1\1\0"+
    "\2\1\14\0\7\1\72\0\2\1\1\0\1\1\2\0\2\1\1\0"+
    "\1\1\2\0\1\1\6\0\4\1\1\0\7\1\1\0\3\1\1\0"+
    "\1\1\1\0\1\1\2\0\2\1\1\0\4\1\1\0\2\1\11\0"+
    "\1\1\2\0\5\1\1\0\1\1\25\0\2\1\42\0\1\1\77\0"+
    "\10\1\1\0\42\1\35\0\4\1\164\0\42\1\1\0\5\1\1\0"+
    "\2\1\45\0\6\1\112\0\46\1\12\0\51\1\7\0\132\1\5\0"+
    "\104\1\5\0\122\1\6\0\7\1\1\0\77\1\1\0\1\1\1\0"+
    "\4\1\2\0\7\1\1\0\1\1\1\0\4\1\2\0\47\1\1\0"+
    "\1\1\1\0\4\1\2\0\37\1\1\0\1\1\1\0\4\1\2\0"+
    "\7\1\1\0\1\1\1\0\4\1\2\0\7\1\1\0\7\1\1\0"+
    "\27\1\1\0\37\1\1\0\1\1\1\0\4\1\2\0\7\1\1\0"+
    "\47\1\1\0\23\1\105\0\125\1\14\0\u026c\1\2\0\10\1\12\0"+
    "\32\1\5\0\113\1\25\0\15\1\1\0\4\1\16\0\22\1\16\0"+
    "\22\1\16\0\15\1\1\0\3\1\17\0\64\1\43\0\1\1\4\0"+
    "\1\1\103\0\130\1\10\0\51\1\127\0\35\1\63\0\36\1\2\0"+
    "\5\1\u038b\0\154\1\224\0\234\1\4\0\132\1\6\0\26\1\2\0"+
    "\6\1\2\0\46\1\2\0\6\1\2\0\10\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\0\37\1\2\0\65\1\1\0\7\1\1\0"+
    "\1\1\3\0\3\1\1\0\7\1\3\0\4\1\2\0\6\1\4\0"+
    "\15\1\5\0\3\1\1\0\7\1\164\0\1\1\15\0\1\1\202\0"+
    "\1\1\4\0\1\1\2\0\12\1\1\0\1\1\3\0\5\1\6\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\4\1\1\0\3\1\1\0"+
    "\7\1\3\0\3\1\5\0\5\1\u0ebb\0\2\1\52\0\5\1\5\0"+
    "\2\1\4\0\126\1\6\0\3\1\1\0\132\1\1\0\4\1\5\0"+
    "\50\1\4\0\136\1\21\0\30\1\70\0\20\1\u0200\0\u19b6\1\112\0"+
    "\u51a6\1\132\0\u048d\1\u0773\0\u2ba4\1\u215c\0\u012e\1\2\0\73\1\225\0"+
    "\7\1\14\0\5\1\5\0\1\1\1\0\12\1\1\0\15\1\1\0"+
    "\5\1\1\0\1\1\1\0\2\1\1\0\2\1\1\0\154\1\41\0"+
    "\u016b\1\22\0\100\1\2\0\66\1\50\0\14\1\164\0\5\1\1\0"+
    "\207\1\44\0\32\1\6\0\32\1\13\0\131\1\3\0\6\1\2\0"+
    "\6\1\2\0\6\1\2\0\3\1\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\1\1\0\1\4";

  private static int [] zzUnpackAction() {
    int [] result = new int[8];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\6\0\14\0\22\0\30\0\36\0\36\0\6";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[8];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int ZZ_TRANS [] = {
    1, 2, 3, 3, 4, 5, -1, -1, -1, -1, 
    -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, 
    3, 3, -1, -1, 4, 4, 4, -1, 4, 4, 
    6, 6, 6, 6, 6, 7, 
  };

  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[8];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
    private static ListScanner scanner;

    /**
     * Returns the shared instance of <code>ListScanner</code>. If it has
     * previously been created, it is reset with the given reader.
     * <p>
     * This method is used to keep from creating a new <code>ListScanner</code>
     * every time a list is read. This greatly reduces overhead in creating
     * the character tables, etc.
     * @since EUGFile 1.03.00
     */
    private static ListScanner getScanner(java.io.Reader reader) {
        if (scanner == null) {
            scanner = new ListScanner(reader);
        } else {
            scanner.yyreset(reader);
        }
        return scanner;
    }
            
    /**
     * Parses an array of strings from the given string. This is like
     * <code>str.split("\\s+")</code> except that it allows for quoted strings
     * with whitespace enclosed.
     * @param list the whitespace-delimited list of strings. Note that quoted
     * and unquoted strings can be mixed freely.
     * @return the array of strings.
     * @see #parseList(String)
     */
    static String[] parseArray(String list) {
        try {
            return getScanner(new java.io.StringReader(list)).parseArray();
        } catch (Exception ex) {
            System.err.println("Error reading list!");
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Parses a list of strings from the given string. This is like
     * <code>str.split("\\s+")</code> except that it allows for quoted strings
     * with whitespace enclosed and it returns a list.
     * @param list the whitespace-delimited list of strings. Note that quoted
     * and unquoted strings can be mixed freely.
     * @return the list of strings.
     * @see #parseArray(String)
     */
    static List<String> parseList(String list) {
        try {
            return getScanner(new java.io.StringReader(list)).parseList();
        } catch (Exception ex) {
            System.err.println("Error reading list!");
            ex.printStackTrace();
            return null;
        }
    }

    private String[] parseArray() throws java.io.IOException {
        final List<String> list = new ArrayList<String>();
        String tmp;
        while ((tmp = yylex()) != null)
            list.add(tmp);

        return list.toArray(new String[list.size()]);
    }

    private List<String> parseList() throws java.io.IOException {
        final List<String> list = new ArrayList<String>();
        String tmp;
        while ((tmp = yylex()) != null)
            list.add(tmp);

        return list;
    }

    private void badChar(char c) {
        System.err.println("Illegal list character: \'" + c +
            "\' (#" + Integer.toHexString((int)c) + ")");
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  ListScanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  ListScanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1152) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  private final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  private final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  private final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  private final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  private final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  private final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  private final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private String yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { return yytext().substring(1, yylength() - 1);
          }
        case 5: break;
        case 1: 
          { badChar(yycharat(0)); return yylex();
          }
        case 6: break;
        case 2: 
          { return yytext();
          }
        case 7: break;
        case 3: 
          { break;
          }
        case 8: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {     return null;
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
