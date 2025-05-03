# Cong_Nge_Java
Xây dụng ứng dụng quản lý bán hoa

#Làm việc với Git
1. Đi tới nhánh main
git checkout main
2. Pull code mới nhất từ nhánh main về
git pull origin main
3. Tạo branch mới từ nhánh main
git checkout-b <tên nhánh mới>
4. Tạo remote cho nhánh mới
git push -u origin <tên nhánh mới>
5. Code trên nhánh mới
6. Add tất cả những thay đổi vào nhánh mới
git add .
7. Commit tất cả những thay đổi vào nhánh mới
git commit -m "<nội dung mô tả những thay đổi>"
8. Push những thay đổi lên remote
git push origin <tên nhánh mới>
9. Tạo pull request cho nhánh mới
10. So sánh những thay đổi trên nhánh mới với main xem đúng chưa
11. Merge vào main nếu không có conflict xảy ra
12. Trường hợp bị conflict -> fix conflict trước khi Merge 

#Làm việc với source code
1. Chức năng đặt trong QLBH_Function
2. Trong QLBH_MVC
Modal: chứa code connect với data base
View: Tạo giao diện
Controller: chứa code tương tác với View, những gì thể hiện trên giao diện