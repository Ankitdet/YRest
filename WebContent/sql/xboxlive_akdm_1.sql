--- select  u.id,u.f_name,u.m_name,u.l_name,u.phone,u.user_image as image,a.area_title as sector from users u left join areas a on a.area_id=u.area_id;




select u.id,u.f_name,u.m_name,u.l_name,u.phone,u.user_image as image from users u ;