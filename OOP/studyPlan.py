class Course:
    def __init__(self,course_name,credit_hrs,total_marks=0,out_of=0):
        self.course_name=course_name
        self.credit_hrs=credit_hrs
        self.total_marks=total_marks
        self.out_of=out_of
        
        if(credit_hrs==4):
            self.lab_total_marks=0
            self.lab_out_of=0

    #lab
    def add_lab_marks(self,obtained_marks,total_marks,weight):
        self.lab_total_marks+= (obtained_marks/total_marks)*weight
        self.lab_out_of+=weight
    def add_lab_assign(self,obtained,total):
        self.add_lab_marks(obtained,total,25/4)
    def add_lab_sess1(self,obtained,total):
        self.add_lab_marks(obtained,total,10)
    def add_lab_sess2(self,obtained,total):
        self.add_lab_marks(obtained,total,15)
    def add_lab_terminal(self,obtained,total):
        self.add_lab_marks(obtained,total,50) 

       #theory 
    def add_marks(self,obtained_marks,total_marks,weight):
        self.total_marks+=((obtained_marks/total_marks)*weight)
        self.out_of+=weight
    def add_sess1(self,obtained,total): #adds marks
        self.add_marks(obtained,total,10)
    def add_sess2(self,obtained,total):
        self.add_marks(obtained,total,15)
    def add_terminal(self,obtained,total):
        self.add_marks(obtained,total,50)
    def add_quiz(self,obtained,total):
        self.add_marks(obtained,total,3.75)
    def add_assign(self,obtained,total):
        self.add_marks(obtained,total,2.5)

    
    def calc_marks(self,obtained,total,weight):
        return (obtained/total)*weight
    def calc_marks_theory(self):
        return self.calc_marks(self.total_marks,self.out_of,100)
    def calc_marks_lab(self):
        return self.calc_marks(self.lab_total_marks,self.lab_out_of,100)
    def get_theory_marks(self):
        return (self.total_marks,self.out_of)
    def get_lab_marks(self):
        return (self.lab_total_marks,self.lab_out_of)
    
    def calc_marks_overall(self):
        if(self.credit_hrs==4):
            return self.calc_marks(self.total_marks,self.out_of,75)+self.calc_marks(self.lab_total_marks,self.lab_out_of,25)
        else:
            return self.calc_marks_theory()
    
    #for valid entered marks
    def calc_gpa(self,marks):
        grade=["A","A-","B+","B","B-","C+","C","C-","D"]
        gpa = [4,3.7,3.3,3,2.7,2.3,2,1.7,1.3]
        count=0
        for i in range(90,49,-5):
            if(marks>=i):
                return (gpa[count],grade[count])
            count+=1
        return (0,"F")
    def calc_gpa_theory(self):
        return self.calc_gpa(self.calc_marks_theory())
    def calc_gpa_lab(self):
        return self.calc_gpa(self.calc_marks_lab())
    def calc_gpa_overall(self):
        return self.calc_gpa(self.calc_marks_overall())

class Display:
    def __init__(self,course_name,credit_hrs,course):  #course dictionary
        self.course=course
        self.credit_hrs=credit_hrs
        self.course_name = course_name
    def read_course(self):
        c = Course(self.course_name,self.credit_hrs)
        for i in self.course["a"]:
            try:
                c.add_assign(i[0],i[1])
            except :
                pass
        try:
            for i in self.course["q"]:
                try:
                    c.add_quiz(i[0],i[1])
                except :
                    pass
        except:
            pass
    
        ops = {"s1":c.add_sess1,"s2":c.add_sess2,"t":c.add_terminal}
        for i in ops:
            try:
                ops[i](self.course[i][0],self.course[i][1])
            except:
                pass
        
        return c
    def view_course(self):
        c=self.read_course()
        print(self.course_name,end="\t")
        for i in self.course["a"]:
            try:
                print(i[0],"/",i[1],end="\t")
            except :
                print("0 / 0",end="\t")
        try:
            for i in self.course["q"]:
                try:
                    print(i[0],"/",i[1],end="\t")
                except :
                    print("0 / 0",end="\t")
        except:
            print(4*"  -    ",end="\t")
        ops = ["s1","s2","t"]
        for i in ops:
            try:
                print(self.course[i][0],"/",self.course[i][1],end="\t")
            except:
                print("0 / 0",end="\t")
        print(int(c.calc_marks_overall()),"/",100,end="\t")
        print(c.calc_gpa_overall()[0],"/",4,end="\t")
        print(c.calc_gpa_overall()[1])
    def read_course_lab(self,lab_dict):
        c=self.read_course()
        for i in lab_dict["a"]:
            try:
                c.add_lab_assign(i[0],i[1])
            except :
                pass
        ops = {"s1":c.add_lab_sess1,"s2":c.add_lab_sess2,"t":c.add_lab_terminal}
        for i in ops:
            try:
                ops[i](self.course[i][0],self.course[i][1])
            except:
                pass
        
        return c