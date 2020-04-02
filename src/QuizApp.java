import java.util.Scanner;



//class representing the quiz
class Quiz {


  //starts the quiz
  void begin() {
    Question q1 = new Question("Which is a valid keyoword in java?",
        "interface",
        "inherit",
        "unsigned",
        "derive",
        new Answer("interface"));
    Question q2 = new Question("What is the capital of Florida?",
        "Tampa",
        "Tallahase",
        "Miami",
        "Jacksonville",
        new Answer("Tallahase"));
    Question q3 = new Question("Who won the 2019 Stanley Cup?",
        "Tampa Bay Ligthning",
        "Boston Bruins",
        "St.Louis Blues",
        "Toronto Maple Leafs",
        new Answer("St.Louis Blues"));
    Question q4 = new Question("What is the largest planet in our solor system?",
        "Jupiter",
        "Mars",
        "Earth",
        "Saturn",
        new Answer("Jupiter"));
    Question q5 = new Question("Whats the name of Shakesspeare's theater?",
        "Golden Garden",
        "Amalie",
        "The Globe",
        "The Madison",
        new Answer("The Globe"));

    Question questionsArr[] = {q1, q2, q3, q4, q5};
    int total = 0;
    int correct = 0;
    int wrong = 0;

    for(Question q: questionsArr) {
      System.out.println(q.getQuestion());
      System.out.println("A. " + q.getOpt1());
      System.out.println("B. " +q.getOpt2());
      System.out.println("C. " + q.getOpt3());
      System.out.println("D. " + q.getOpt4());
      System.out.println("\nEnter an answer");

      Scanner scanner = new Scanner(System.in);
      char option = scanner.next().charAt(0);
      String answer = "";

      switch(option) {
      case 'A':
        answer = q.opt1;
        break;
      case 'B':
        answer = q.opt2;
        break;
      case 'C':
        answer = q.opt3;
        break;
      case 'D':
        answer = q.opt4;
        break;
      default:break;
      }

      if(answer.equals(q.ans.getAnswer())) {
        System.out.println("-----------");
        System.out.println("Correct Answer!");
        System.out.println("-----------");
        correct++;
      }
      else {
        System.out.println("-----------");
        System.out.println("Wrong Answer");
        System.out.println("-----------");
        wrong++;
      }
      total++;
    }

    IResult r = new Result(total, correct, wrong);
    r.showResults();

  }
}

// class representing a question
class Question {

  String question;
  String opt1;
  String opt2;
  String opt3;
  String opt4;
  Answer ans;

  Question(String question, String opt1, String opt2,
      String opt3, String op4, Answer ans) {
    super();
    this.question = question;
    this.opt1 = opt1;
    this.opt2= opt2;
    this.opt3 = opt3;
    this.opt4 = op4;
    this.ans = ans;
  }

  //gets question
  public String getQuestion() {
    return question;
  }

  //gets option 1
  public String getOpt1() {
    return opt1;
  }

  //gets option 2
  public String getOpt2() {
    return opt2;
  }

  //gets option 3
  public String getOpt3() {
    return opt3;
  }

  //gets option 4
  public String getOpt4() {
    return opt4;
  }

  //gets answer
  public Answer getAns() {
    return ans;
  }



}

// class representing answer to a question
class Answer { 
  String answer;
  Answer (String answer) {
    super();
    this.answer = answer;
  }

  //gets answer to question
  public String getAnswer() {
    return answer;

  }


}

//result interface
interface IResult {

  void showResults();
  double showPercentage(int correctAnswers, int totalQuestions);
  String showPerformance(double percentage);

}

//class representing results of quiz
class Result implements IResult {
  int totalQuestions;
  int correctAnswers;
  int wrongAnswers;

  Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
    super();
    this.totalQuestions = totalQuestions;
    this.correctAnswers = correctAnswers;
    this.wrongAnswers = wrongAnswers;

  }

  //displays results of the quizA
  public void showResults() {
    System.out.println("Your Result:");
    System.out.println("Total Questions:" +       totalQuestions);
    System.out.println("Correct Answers:" +       correctAnswers);
    System.out.println("Wrong Answers:" +         wrongAnswers);
    System.out.println("Percentage:" +            showPercentage(correctAnswers, totalQuestions));
    System.out.println("Overall Performance:" +   showPerformance(showPercentage(totalQuestions, correctAnswers)));

  }

  //calculates score or percentage of the quiz
  public double showPercentage(int correctAnswers, int totalQuestions) {

    return ((double) correctAnswers / totalQuestions) * 100;
  }

  //shows how well the user performed on the quiz 
  public String showPerformance(double percentage) {
    String p = "";
    if(percentage > 60) {
      p = "Good";
    }
    if(percentage < 40) {
      p ="Poor";
    }
    else {
      p ="Average";
    }
    return p;
  }
}

//runs quiz 
class QuizApplication {
  public static void main(String[] args) {
    Quiz q = new Quiz();
    q.begin();
  }
}

