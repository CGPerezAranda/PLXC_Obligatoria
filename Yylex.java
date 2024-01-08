// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: PLXC.flex


import java_cup.runtime.*;

@SuppressWarnings("fallthrough")
class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int CARACTERES = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\25\u0100\1\u0200\11\u0100\1\u0300\17\u0100\1\u0400\u10cf\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
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
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\2\2\1\3\1\2\22\0\1\2\1\4"+
    "\1\5\3\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\11\22\1\6\1\23"+
    "\1\24\1\25\1\26\2\6\4\27\1\30\25\27\1\31"+
    "\1\32\1\33\1\6\1\34\1\6\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\2\27\1\46"+
    "\1\27\1\47\1\50\1\51\1\27\1\52\1\53\1\54"+
    "\1\55\1\27\1\56\3\27\1\57\1\60\1\61\1\6"+
    "\6\0\1\2\32\0\1\2\u01df\0\1\2\177\0\13\2"+
    "\35\0\2\2\5\0\1\2\57\0\1\2\240\0\1\2"+
    "\377\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1280];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
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
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\1\1\13\2\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\7\21\1\24"+
    "\1\1\1\25\1\26\1\27\1\26\1\30\1\31\5\0"+
    "\1\32\1\33\1\34\1\21\1\35\3\21\1\36\3\21"+
    "\1\37\5\0\1\40\3\21\1\41\1\42\2\21\6\0"+
    "\1\43\1\44\3\21\3\0\1\45\2\0\1\40\1\46"+
    "\1\47\1\50\1\0\1\51\2\0\1\52\1\53";

  private static int [] zzUnpackAction() {
    int [] result = new int[98];
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
    "\0\0\0\62\0\144\0\226\0\144\0\310\0\372\0\144"+
    "\0\u012c\0\144\0\144\0\144\0\144\0\144\0\u015e\0\144"+
    "\0\144\0\u0190\0\144\0\u01c2\0\u01f4\0\u0226\0\u0258\0\144"+
    "\0\144\0\u028a\0\u02bc\0\u02ee\0\u0320\0\u0352\0\u0384\0\u03b6"+
    "\0\144\0\u03e8\0\144\0\144\0\144\0\u041a\0\144\0\144"+
    "\0\u044c\0\u047e\0\u04b0\0\u04e2\0\u0514\0\144\0\144\0\144"+
    "\0\u0546\0\u0258\0\u0578\0\u05aa\0\u05dc\0\u0258\0\u060e\0\u0640"+
    "\0\u0672\0\144\0\u06a4\0\u06d6\0\u0708\0\u073a\0\u076c\0\u079e"+
    "\0\u07d0\0\u0802\0\u0834\0\u0258\0\u0258\0\u0866\0\u0898\0\u08ca"+
    "\0\u08fc\0\u092e\0\u0960\0\u0992\0\u09c4\0\u0258\0\u0258\0\u09f6"+
    "\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\144\0\u0b22\0\u0b54"+
    "\0\u0b54\0\u0258\0\u0258\0\u0258\0\u0b86\0\144\0\u0bb8\0\u0bea"+
    "\0\144\0\144";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[98];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\5\1\6\2\3\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\2\27\1\30\1\3"+
    "\1\31\1\3\2\27\1\32\1\33\1\34\1\35\2\27"+
    "\1\36\3\27\1\37\4\27\1\40\1\41\1\42\1\43"+
    "\4\0\4\44\1\45\21\44\1\46\27\44\65\0\1\5"+
    "\103\0\1\47\43\0\1\50\111\0\1\51\2\0\1\52"+
    "\2\0\1\53\62\0\1\54\32\0\1\55\1\0\2\22"+
    "\64\0\1\56\61\0\1\57\61\0\1\60\55\0\2\27"+
    "\4\0\2\27\3\0\23\27\24\0\2\27\4\0\2\27"+
    "\3\0\10\27\1\61\12\27\24\0\2\27\4\0\2\27"+
    "\3\0\14\27\1\62\6\27\24\0\2\27\4\0\2\27"+
    "\3\0\12\27\1\63\10\27\24\0\2\27\4\0\2\27"+
    "\3\0\12\27\1\64\1\27\1\65\6\27\24\0\2\27"+
    "\4\0\2\27\3\0\6\27\1\66\4\27\1\67\7\27"+
    "\24\0\2\27\4\0\2\27\3\0\16\27\1\70\4\27"+
    "\24\0\2\27\4\0\2\27\3\0\10\27\1\71\12\27"+
    "\63\0\1\72\6\0\1\44\2\0\1\44\21\0\1\44"+
    "\3\0\1\44\3\0\1\44\4\0\1\44\2\0\1\44"+
    "\1\0\1\44\1\73\50\0\1\74\63\0\1\75\62\0"+
    "\1\76\53\0\1\77\41\0\2\100\60\0\2\27\4\0"+
    "\2\27\3\0\1\27\1\101\21\27\24\0\2\27\4\0"+
    "\2\27\3\0\17\27\1\102\3\27\24\0\2\27\4\0"+
    "\2\27\3\0\14\27\1\103\6\27\24\0\2\27\4\0"+
    "\2\27\3\0\16\27\1\104\4\27\24\0\2\27\4\0"+
    "\2\27\3\0\20\27\1\105\2\27\24\0\2\27\4\0"+
    "\2\27\3\0\11\27\1\106\11\27\24\0\2\27\4\0"+
    "\2\27\3\0\11\27\1\107\11\27\24\0\2\110\12\0"+
    "\6\110\54\0\1\111\74\0\1\112\65\0\1\113\54\0"+
    "\1\114\33\0\2\100\5\0\1\115\10\0\1\115\41\0"+
    "\2\27\4\0\2\27\3\0\16\27\1\116\4\27\24\0"+
    "\2\27\4\0\2\27\3\0\5\27\1\117\15\27\24\0"+
    "\2\27\4\0\2\27\3\0\1\27\1\120\21\27\24\0"+
    "\2\27\4\0\2\27\3\0\13\27\1\121\7\27\24\0"+
    "\2\27\4\0\2\27\3\0\12\27\1\122\10\27\24\0"+
    "\2\123\12\0\6\123\71\0\1\124\44\0\1\125\36\0"+
    "\1\126\112\0\1\127\32\0\1\130\1\0\1\130\2\0"+
    "\2\131\60\0\2\27\4\0\2\27\3\0\20\27\1\132"+
    "\2\27\24\0\2\27\4\0\2\27\3\0\20\27\1\133"+
    "\2\27\24\0\2\27\4\0\2\27\3\0\5\27\1\134"+
    "\15\27\24\0\2\135\12\0\6\135\31\0\1\136\123\0"+
    "\1\137\61\0\1\140\26\0\2\131\60\0\2\44\12\0"+
    "\6\44\31\0\1\141\113\0\1\142\15\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[3100];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\1\11\2\1\1\11\1\1\5\11"+
    "\1\1\2\11\1\1\1\11\4\1\2\11\7\1\1\11"+
    "\1\1\3\11\1\1\2\11\5\0\3\11\11\1\1\11"+
    "\5\0\10\1\6\0\5\1\3\0\1\11\2\0\4\1"+
    "\1\0\1\11\2\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[98];
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

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new Error("Illegal character <"+yytext()+">");
            }
          // fall through
          case 44: break;
          case 2:
            { 
            }
          // fall through
          case 45: break;
          case 3:
            { return new Symbol(sym.NOT);
            }
          // fall through
          case 46: break;
          case 4:
            { yybegin(CARACTERES);
            }
          // fall through
          case 47: break;
          case 5:
            { return new Symbol(sym.AP);
            }
          // fall through
          case 48: break;
          case 6:
            { return new Symbol(sym.CP);
            }
          // fall through
          case 49: break;
          case 7:
            { return new Symbol(sym.POR);
            }
          // fall through
          case 50: break;
          case 8:
            { return new Symbol(sym.MAS);
            }
          // fall through
          case 51: break;
          case 9:
            { return new Symbol(sym.COMA);
            }
          // fall through
          case 52: break;
          case 10:
            { return new Symbol(sym.MENOS);
            }
          // fall through
          case 53: break;
          case 11:
            { return new Symbol(sym.DIV);
            }
          // fall through
          case 54: break;
          case 12:
            { return new Symbol(sym.NUM, new String(yytext()) );
            }
          // fall through
          case 55: break;
          case 13:
            { return new Symbol(sym.PYC);
            }
          // fall through
          case 56: break;
          case 14:
            { return new Symbol(sym.MENOR);
            }
          // fall through
          case 57: break;
          case 15:
            { return new Symbol(sym.ASIG);
            }
          // fall through
          case 58: break;
          case 16:
            { return new Symbol(sym.MAYOR);
            }
          // fall through
          case 59: break;
          case 17:
            { return new Symbol(sym.IDENT, new String( yytext() ));
            }
          // fall through
          case 60: break;
          case 18:
            { return new Symbol(sym.AC);
            }
          // fall through
          case 61: break;
          case 19:
            { return new Symbol(sym.CC);
            }
          // fall through
          case 62: break;
          case 20:
            { return new Symbol(sym.ALL);
            }
          // fall through
          case 63: break;
          case 21:
            { return new Symbol(sym.CLL);
            }
          // fall through
          case 64: break;
          case 22:
            { return new Symbol(sym.ASCII, new String(yytext()) );
            }
          // fall through
          case 65: break;
          case 23:
            { yybegin(YYINITIAL);
            }
          // fall through
          case 66: break;
          case 24:
            { return new Symbol(sym.DIF);
            }
          // fall through
          case 67: break;
          case 25:
            { return new Symbol(sym.AND);
            }
          // fall through
          case 68: break;
          case 26:
            { return new Symbol(sym.MENORIGUAL);
            }
          // fall through
          case 69: break;
          case 27:
            { return new Symbol(sym.IGUAL);
            }
          // fall through
          case 70: break;
          case 28:
            { return new Symbol(sym.MAYORIGUAL);
            }
          // fall through
          case 71: break;
          case 29:
            { return new Symbol(sym.DO);
            }
          // fall through
          case 72: break;
          case 30:
            { return new Symbol(sym.IF);
            }
          // fall through
          case 73: break;
          case 31:
            { return new Symbol(sym.OR);
            }
          // fall through
          case 74: break;
          case 32:
            { return new Symbol(sym.REAL, new String(yytext()) );
            }
          // fall through
          case 75: break;
          case 33:
            { return new Symbol(sym.FOR);
            }
          // fall through
          case 76: break;
          case 34:
            { return new Symbol(sym.INT);
            }
          // fall through
          case 77: break;
          case 35:
            { return new Symbol(sym.CHAR);
            }
          // fall through
          case 78: break;
          case 36:
            { return new Symbol(sym.ELSE);
            }
          // fall through
          case 79: break;
          case 37:
            { return new Symbol(sym.CASTINT);
            }
          // fall through
          case 80: break;
          case 38:
            { return new Symbol(sym.FLOAT);
            }
          // fall through
          case 81: break;
          case 39:
            { return new Symbol(sym.PRINT);
            }
          // fall through
          case 82: break;
          case 40:
            { return new Symbol(sym.WHILE);
            }
          // fall through
          case 83: break;
          case 41:
            { return new Symbol(sym.CASTCHAR);
            }
          // fall through
          case 84: break;
          case 42:
            { return new Symbol(sym.CASTFLOAT);
            }
          // fall through
          case 85: break;
          case 43:
            { return new Symbol(sym.LENGTH);
            }
          // fall through
          case 86: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
