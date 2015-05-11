$(document).ready(function(){

	var width = ($(window).width()-1000)/2;
	$('.headDiv').css('marginLeft',width+'px');
	$('.contentDiv').css('marginLeft',width+'px');
	$('tr[id^="incomeOne"]').addClass('firstForm');
	$('tr[id^="incomeTwo"]').addClass('secondForm').hide();
	$('tr[id^="expendOne"]').addClass('firstForm');
	$('tr[id^="expendTwo"]').addClass('secondForm').hide();
	$('i[class="icon-edit icon-large"]').attr('href','#modifyPanel').leanModal({ top: 300, overlay: 0.45, closeButton: '.hidemodal' });
	$('a[id^="add"][id$="ProOne"]').attr('href','#addProOnePanel').leanModal({ top: 300, overlay: 0.45, closeButton: '.hidemodal' });
	$('a[id^="add"][id$="ProTwo"]').attr('href','#addProTwoPanel').leanModal({ top: 300, overlay: 0.45, closeButton: '.hidemodal' });
	$('#block_incomeTab').show().siblings('div').hide();

	//顶部的导航按钮事件处理
	$('body').on('click','li[id^="nav_tab_"]',function(){
		if($(this).hasClass('active')){
		}
		else{
			$(this).addClass('active').siblings().removeClass('active');
		}
		var tabId = $(this).attr('id');
		if(tabId == 'nav_tab_income'){
			$('#block_incomeTab').show().siblings('div').hide();
		}
		else if(tabId == 'nav_tab_expire'){
			$('#block_expendTab').show().siblings('div').hide();
		}
		else if(tabId == 'nav_tab_application'){
			$('#block_application').show().siblings('div').hide();
		}
		else if(tabId == 'nav_tab_personal'){
			$('#block_personal').show().siblings('div').hide();
		}
	});

	//收入一级菜单的前三个TD触发二级菜单的隐藏和显示
	$('body').on('click','tr[id^="incomeOne"]>td:even',function(){
		var id_pre = $(this).closest('tr').attr('id');
		$('tr[id^="incomeTwo"]').each(function(){
			var id_two = $(this).attr('parent');
			if(id_pre == id_two){
				$(this).toggle();
			}
			else{
				$(this).hide();
			}
		})
	});
	$('body').on('click','tr[id^="incomeOne"]>td:odd:even',function(){
		var id_pre = $(this).closest('tr').attr('id');
		$('tr[id^="incomeTwo"]').each(function(){
			var id_two = $(this).attr('parent');
			if(id_pre == id_two){
				$(this).toggle();
			}
			else{
				$(this).hide();
			}
		})
	});
	//支出一级菜单的前三个TD触发二级菜单的隐藏和显示
	$('body').on('click','tr[id^="expendOne"]>td:even',function(){
		var id_pre = $(this).closest('tr').attr('id');
		$('tr[id^="expendTwo"]').each(function(){
			var id_two = $(this).attr('parent');
			if(id_pre == id_two){
				$(this).toggle();
			}
			else{
				$(this).hide();
			}
		})
	});
	$('body').on('click','tr[id^="expendOne"]>td:odd:even',function(){
		var id_pre = $(this).closest('tr').attr('id');
		$('tr[id^="expendTwo"]').each(function(){
			var id_two = $(this).attr('parent');
			if(id_pre == id_two){
				$(this).toggle();
			}
			else{
				$(this).hide();
			}
		})
	});
	//每条记录的修改按钮操作
	$('body').on('click','i[class="icon-edit icon-large"]',function(){
		document.modifyName.reset();
		var proOneId = $(this).parent().parent().attr('id');
		$('input#proId').val(proOneId.substr(9));
		var idPrefix = proOneId.substr(0,9);
		if('incomeOne'== idPrefix || 'expendOne' == idPrefix){
			$('input#proLevel').val('1');
			$('input#proNameModify').val($(this).parent().parent().children().eq(0).text());
		}
		else {
			$('input#proLevel').val('2');
			$('input#proNameModify').val($(this).parent().parent().children().eq(1).text());
		}
	});
	//每条记录的删除按钮操作
	$('body').on('click','i[class="icon-trash icon-large"]',function(){
		var thisID = $(this).parent().parent().attr('id');
		var idPrefix = thisID.substr(0,9);
		var idSuffix = thisID.substr(9);
		var level;
		if('incomeTwo' == idPrefix || 'expendTwo' == idPrefix){
			level = '2';
		}
		else{
			level = '1';
		}
		var jsonObject={
			id:idSuffix,
			level:level
		}
		var jsonString = JSON.stringify(jsonObject);
		$.ajax({
			contentType : 'application/json',
			url:'/javaThree/main/deletePro.json',
			type:'POST',
			data:jsonString,
			dataType:'json',
			success:function(data) {
				var status = data.opstatus;
				var id = data.opid;
				var type = data.optype;
				var level = data.oplevel;
				var htmlId;
				if (status == "success") {
					if (type == '0') {
						if (level == '1') {
							htmlId = 'incomeOne' + id;
						}
						else {
							htmlId = 'incomeTwo' + id;
						}
					}
					else {
						if (level == '1') {
							htmlId = 'expendOne' + id;
						}
						else {
							htmlId = 'expendTwo' + id;
						}
					}
					if (level == '1') {
						$('tr[parent='+htmlId+']').remove();
						$('#' + htmlId).remove();
					}
					else {
						$('#' + htmlId).remove();
					}
				}
				else{
					alert("删除失败!");
				}
			}
		})
	});
	//新增一级项目按钮事件，设置type为“0”收入或者“1”支出
	$('body').on('click','a[id^="add"][id$="ProOne"]',function(){
		document.addProOne.reset();
		var btnID = $(this).attr('id');
		if(btnID == 'addIncomeProOne'){
			$('input#proOneNameType').val('0');
		}
		else{
			$('input#proOneNameType').val('1');
		}
	});
	//新增二级项目按钮事件，设置弹出框中的一级菜单ID和名称
	$('body').on('click','a[id^="add"][id$="ProTwo"]',function(){
		document.addProTwo.reset();
		var proOneId = $(this).parent().parent().attr('parent');
		$('input#proOneId').val(proOneId.substr(9));
		if(proOneId.substr(0,6) == 'income'){
			$('tr[id^="incomeOne"]').each(function(){
				var id_one = $(this).attr('id');
				if(proOneId == id_one){
					$('input#proOneName').val($(this).children().eq(0).text());
				}
			})
		}
		else{
			$('tr[id^="expendOne"]').each(function(){
				var id_one = $(this).attr('id');
				if(proOneId == id_one){
					$('input#proOneName').val($(this).children().eq(0).text());
				}
			})
		}
	});
	//新增一级菜单时的提交按钮触发动作
	$('body').on('click','#proOneNameAddBtn',function(){
		var proOneNameAddTmp = $('#proOneNameAdd').val();
		if(typeof(proOneNameAddTmp)=='undefined' || proOneNameAddTmp=='' || $.trim(proOneNameAddTmp)==''){
			return false;
		}
		var jsonObject={
			proOneType:$('#proOneNameType').val(),
			proOneNameAdd:$('#proOneNameAdd').val()
		}
		var jsonString=JSON.stringify(jsonObject);
		$.ajax({
			contentType : 'application/json',
			url:'/javaThree/main/addProOne.json',
			type:'POST',
			data:jsonString,
			dataType:'json',
			success:function(data){
				var status = data.opstatus;
				var type = data.optype;
				var id = data.opid;
				var name = data.opname;
				var amount = data.amount;
				if (status == 'success'){
					if (type == '0') {
						var html = '<tr id="incomeOne' + id + '" class="firstForm"><td>' + name + '</td><td></td><td>' + amount + '</td><td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td></tr>';
						html += '<tr id="incomeTwo'+ id +'btn" parent="incomeOne'+ id +'" style="display: none;"><td></td><td><a class="btn btn-info" id="addIncome'+ id +'ProTwo"><i class="icon-plus-sign-alt icon-large"></i>&nbsp;&nbsp;新增二级菜单</a></td><td></td><td></td></tr>';
						$('tr[id=incomeOneAddBtn]').before(html);
					}
					else {
						var html = '<tr id="expendOne' + id + '" class="firstForm"><td>' + name + '</td><td></td><td>' + amount + '</td><td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td></tr>';
						html += '<tr id="expendTwo'+ id +'btn" parent="expendOne'+ id +'" style="display: none;"><td></td><td><a class="btn btn-info" id="addExpend'+ id +'ProTwo"><i class="icon-plus-sign-alt icon-large"></i>&nbsp;&nbsp;新增二级菜单</a></td><td></td><td></td></tr>';
						$('tr[id=expendOneAddBtn]').before(html);
					}
					$('i[class="icon-edit icon-large"]').attr('href','#modifyPanel').leanModal({ top: 300, overlay: 0.45, closeButton: '.hidemodal' });
					$('a[id^="add"][id$="ProTwo"]').attr('href','#addProTwoPanel').leanModal({ top: 300, overlay: 0.45, closeButton: '.hidemodal' });
				}
				else {
					alert('新增一级菜单失败!');
				}
			}
		})
	});
	//新增二级菜单的弹出窗提交动作
	$('body').on('click','#proTwoNameAddBtn',function(){
		var proTwoNameAddTmp = $('#proTwoNameAdd').val();
		if(typeof(proTwoNameAddTmp)=='undefined' || proTwoNameAddTmp=='' || $.trim(proTwoNameAddTmp)==''){
			return false;
		}
		var jsonObject={
			proOneId:$('#proOneId').val(),
			proTwoNameAdd:$('#proTwoNameAdd').val()
		}
		var jsonString=JSON.stringify(jsonObject);
		$.ajax({
			contentType : 'application/json',
			url:'/javaThree/main/addProTwo.json',
			type:'POST',
			data:jsonString,
			dataType:'json',
			success:function(data){
				var status = data.opstatus;
				var type = data.optype;
				var id = data.opid;
				var parentId = data.parentId;
				var name = data.opname;
				var amount = data.amount;
				if(status =='success'){
					if(type == '0'){
						var html = '<tr id="incomeTwo'+id+'" parent="incomeOne'+parentId+'"><td></td><td>'+name+'</td><td>'+amount+'</td><td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td></tr>';
						var btnId = 'incomeTwo'+parentId+'btn';
						$('tr[id^=incomeTwo][id$=btn]').each(function(){
							var id_two_btn = $(this).attr("id");
							if(btnId == id_two_btn){
								$(this).before(html);
							}
						})
					}
					else{
						var html = '<tr id="expendTwo'+id+'" parent="expendOne'+parentId+'"><td></td><td>'+name+'</td><td>'+amount+'</td><td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td></tr>';
						var btnId = 'expendTwo'+parentId+'btn';
						$('tr[id^=expendTwo][id$=btn]').each(function(){
							var id_two_btn = $(this).attr("id");
							if(btnId == id_two_btn){
								$(this).before(html);
							}
						})
					}
					$('i[class="icon-edit icon-large"]').attr('href','#modifyPanel').leanModal({ top: 300, overlay: 0.45, closeButton: '.hidemodal' });
				}
				else {
					alert('新增二级菜单失败!');
				}
			}
		})
	});
	//修改项目
	$('body').on('click','#proNameModifyBtn',function(){
		var proNameModifyTmp = $('#proNameModify').val();
		if(typeof(proNameModifyTmp)=='undefined' || proNameModifyTmp=='' || $.trim(proNameModifyTmp)==''){
			return false;
		}
		var jsonObject={
			proId:$('#proId').val(),
			proLevel:$('#proLevel').val(),
			proNameModify:$('#proNameModify').val()
		}
		var jsonString=JSON.stringify(jsonObject);
		$.ajax({
			contentType : 'application/json',
			url:'/javaThree/main/modifyPro.json',
			type:'POST',
			data:jsonString,
			dataType:'json',
			success:function(data){
				var status = data.opstatus;
				var id=data.opid;
				var name = data.opname;
				var level=data.oplevel;
				var type=data.optype;
				var htmlId;
				if(status=='success'){
					if(level=='1'){
						if(type=='0'){
							htmlId='incomeOne'+id;
						}
						else{
							htmlId='expendOne'+id;
						}
						$('#'+htmlId).children().eq(0).html(name);
					}
					if(level=='2'){
						if(type=='0'){
							htmlId='incomeTwo'+id;
						}
						else{
							htmlId='expendTwo'+id;
						}
						$('#'+htmlId).children().eq(1).html(name);
					}
				}
				else{
					alert('修改失败!');
				}
			}
		})

	})
});


