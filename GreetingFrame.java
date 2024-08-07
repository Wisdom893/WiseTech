����   ? �
      javax/swing/JFrame <init> ()V  java/awt/BorderLayout
  
      za/ac/tut/GreetingFrame 	setLayout (Ljava/awt/LayoutManager;)V  	Greetings
     setTitle (Ljava/lang/String;)V
     setSize (II)V	      java/awt/Color BLUE Ljava/awt/Color;
  ! " # setBackground (Ljava/awt/Color;)V % javax/swing/JPanel ' java/awt/FlowLayout
 & 
 $ *  	  , - . namePnl Ljavax/swing/JPanel;	  0 1 . 
surnamePnl 3 java/awt/GridLayout
 2 	  6 7 . nameAndSurnamePnl	  9 : . greetingAreaPnl < javax/swing/border/TitledBorder > javax/swing/border/LineBorder	  @ A  BLACK
 = C  D (Ljava/awt/Color;I)V F We Greet You
 ; H  I 0(Ljavax/swing/border/Border;Ljava/lang/String;)V
 $ K L M 	setBorder (Ljavax/swing/border/Border;)V	  O P . btnsPnl	  R S . mainPnl
 & U  V (I)V	  X Y . 
headingPnl [ javax/swing/border/BevelBorder
 Z U ^ javax/swing/JLabel ` Greeting App: 
 ] b  	  d e f 
headingLbl Ljavax/swing/JLabel; h Name: 	  j k f nameLbl m 	Surname: 	  o p f 
surnameLbl r javax/swing/JTextField
 q U	  u v w 
nameTxtFld Ljavax/swing/JTextField;	  y z w surnameTxtFld | javax/swing/JTextArea
 { ~  	  � � � greetingTxtArea Ljavax/swing/JTextArea;
 { � � � setEditable (Z)V � Hello [name] [surname]
 { � �  setText � javax/swing/JButton � Greet
 � b	  � � � greetBtn Ljavax/swing/JButton; � Clear	  � � � clearBtn � Exit	  � � � exitBtn
 $ � � � add *(Ljava/awt/Component;)Ljava/awt/Component; � North
 $ � � � )(Ljava/awt/Component;Ljava/lang/Object;)V � Center � South
  �
  � � � 
setVisible Code LineNumberTable LocalVariableTable this Lza/ac/tut/GreetingFrame; 
SourceFile GreetingFrame.java !       - .    1 .    7 .    : .    Y .    P .    S .    e f    k f    p f    v w    z w    � �    � �    � �    � �        �  �    *� *� Y� 	� 
*� *��� *� �  *� $Y� &Y� (� )� +*� $Y� &Y� (� )� /*� $Y� 2Y� 4� )� 5*� $Y� &Y� (� )� 8*� 8� ;Y� =Y� ?� BE� G� J*� $Y� &Y� (� )� N*� $Y� Y� 	� )� Q*� $Y� &Y� T� )� W*� W� ZY� \� J*� ]Y_� a� c*� ]Yg� a� i*� ]Yl� a� n*� qY� s� t*� qY� s� x*� {Y(2� }� *� � �*� �� �*� �Y�� �� �*� �Y�� �� �*� �Y�� �� �*� +*� i� �W*� +*� t� �W*� /*� n� �W*� /*� x� �W*� 5*� +� �W*� 5*� /� �W*� 8*� � �W*� N*� �� �W*� N*� �� �W*� N*� �� �W*� Q*� 5�� �*� Q*� 8�� �*� Q*� N�� �**� W�� �**� Q�� �*� ��    �   � *   )  *  +  ,  - & 0 8 1 J 2 \ 3 n 4 � 6 � 7 � 9 � : � < � = � > � @ A C D' E0 G= HJ IW Kc Lo N{ O� Q� R� T� V� W� X� Z� [� \� ^  _
 a b �       � �    �    �