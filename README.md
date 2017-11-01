# ClassScheduling
Project Artificial Intelligence -  Genetic Algorithm
 Thuật giải di truyền giải bài toán xếp thời khóa biểu
 - Dữ liệu đầu vào: 
      + Danh sách phòng học  (Rooms) (3 phòng - Mỗi phòng có 1 sức chứa tối đa)
      + Danh sách các môn học (Courses) (7 môn - Mỗi môn lại có số sinh viên được đăng kí tối đa)
      + Danh sách giảng viên (Instructors) (4 giảng viên)
      + Danh sách các khoảng thời gian (Meeting Times) (4 khoảng thời gian)
 - Dữ liệu đầu ra: Một thời khóa biểu là lịch của 7 môn không vi phạm các ràng buộc như:
      + Một giáo viên không dạy 2 lớp khác nhau trong cùng khoảng thời gian
      + Sức chứa của phòng học không nhỏ hơn số sinh viên tối đa
      + Hai môn khác nhau không học cùng một phòng trong cùng khoảng thời gian
 
 - Phương pháp: Thuật giải di truyền (package algorithm) sẽ đc biểu diễn như sau:
     + Chromosome (Là 1 schedule - thời khóa biểu): 63 bit - là lịch của 7 môn
                      Mỗi môn được biểu diễn: 3 bit - môn học, 2 bit - phòng, 2 bit - giảng viên, 2 bit - thời gian
     + Hàm tính toán độ Fitness được tính dựa trên numbOfConflict (Số lần vi phạm ràng buộc)
       Độ fitness mục tiêu của bài toán là 1 (Khi không còn vi phạm nào)
     + Population: được khởi tạo gồm tập hợp các Schedule với kích thước cho trước
     + Toán tử lai ghép (Crossover)  lai ghép 2 chromosome tại 1 điểm ngẫu nhiên. Tuy nhiên, điểm này không được chọn
       tùy tiện để tránh tạo ra các giá trị vượt phạm vi biểu diễn.
       Sẽ chọn điểm lai ghép này ở các điểm phân chia 7 bit một
       Ví dụ:  Có 2 schedule (ABCDEFG và HIJKLMN) (với A, B, ... N là 1 lớp 9 bit - cả chuỗi là 63 bit)
               thì ta sẽ lai ghép ở các điểm giưã A với B, B với C, hoặc C với D, vv...
     + Toán tử đột biến: Trên chuỗi 63 bit đột biến ngẫu nhiên 1 bit nào đó, chuyển từ 0 -> 1 và ngược lại.
                         Chú ý kiểm tra giá trị đột biến mới có vượt quá phạm vi biểu diễn không.
     + Cả hai toán tử đột biến và lai ghép đều có một tỉ lệ nhất định mới xảy ra.
     
     + Quần thể tiếp theo (next Generation) là quần thể đột biến sau khi đã lai ghép quần thể cũ.
     
     + Tri thức bổ sung: Vì nếu khởi tạo ngẫu nhiên thì numbOfConflict sẽ rất lớn, rất lâu để có thể đạt đến độ Fitness phù hợp
       Do đó, tri thức bổ sung thực tế bài toán sẽ được thêm vào.
       Ở đây tri thức bổ sung là các tiết học sẽ học các môn khác nhau. Và mặc định, sẽ học các môn IT trước, Math sau, và Physical cuối
       cùng. Và môn học mỗi lớp sẽ được giữ cố định suốt thuật toán, không được thay đổi thứ tự 7 môn này cũng nhưu không đột biến, lai
       ghép ở thuộc tính môn học (3 bit đầu của mỗi Class).
     
     + Kết thúc, ta thu được lịch học tối ưu với số Generation trải qua.
     
