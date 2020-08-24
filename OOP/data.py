from  studyPlan import Course,Display

COMM={"q":[(0,5),(4,5),(),()],"a":[(5,5),(),(),()],"s1":(8,12),"s2":(12,15),"t":()}

DSA_th={"q":[(3,5),(),(),()],"a":[(),(),(),()],"s1":(8,10),"s2":(13,15),"t":()}
DSA_lab={"a":[(),(),(),()],"s1":(8,10),"s2":(),"t":()}

ISE_th = {"q":[(8,10),(8,10),(5,10),()],"a":[(7,10),(),(),()],"s1":(8,10),"s2":(14,15),"t":()}
ISE_lab = {"a":[(7,10),(),(),()],"s1":(6,10),"s2":(9,15),"t":()}

OOP_th={"q":[(),(),(),()],"a":[(),(),(),()],"s1":(18,20),"s2":(17,20),"t":()}
OOP_lab={"q":[(),(),(),()],"a":[(),(),(),()],"s1":(5,10),"s2":(10,10),"t":()}

PAK ={"q":[(15,15),(14,15),(15,15),()],"a":[(5,10),(5,10),(17,30),()],"s1":(11,20),"s2":(16,30),"t":()}

def get_title():
        return "      \tA1\tA2\tA3\tA4\tQ1\tQ2\tQ3\tQ4\tS1\tS2\tT\tM\t\tGpa\tG"
def print_course(course_name,credit_hrs,course_dict,lab_dict=None):
    comm=Display(course_name,credit_hrs,course_dict)
    try:
        comm.read_course_lab(lab_dict)
    except:
        pass
    comm.view_course()
    comm=comm.read_course()


list_courses=[DSA_th,ISE_th,OOP_th,DSA_lab,ISE_lab,OOP_lab,COMM,PAK]
name_courses=["DatStr","IntrSE","ObjOrP","LDataSt","LIntSE","LObOrp","CommSk","PakStd"]
print(get_title())
for i in range(0,8):
    try:
        print_course(name_courses[i],3,list_courses[i],list_courses[i+2])
    except:
        pass